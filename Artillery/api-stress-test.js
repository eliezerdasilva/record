import http from 'k6/http'; // Adicione esta linha no topo do arquivo
import { check, group } from 'k6';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

// Configuração dos ambientes
const dotnetBaseURL = 'https://localhost:7287/api';
const javaBaseURL = 'http://localhost:8080/api';
const testId = 1;

export const options = {
  stages: [
    { duration: '30s', target: 10 },
    { duration: '1m', target: 30 },
    { duration: '30s', target: 0 },
  ],
  thresholds: {
    http_req_duration: ['p(95)<500'],
    http_req_failed: ['rate<0.01'],
  },
  insecureSkipTLSVerify: true,
};

function testEndpoints(baseURL) {
  group(`${baseURL} - Listagens`, function () {
    const endpoints = ['user', 'registry', 'address', 'customer'];
    
    endpoints.forEach(endpoint => {
      const res = http.get(`${baseURL}/${endpoint}`);
      check(res, {
        [`${endpoint} - status 200`]: (r) => r.status === 200,
        [`${endpoint} - tempo < 1s`]: (r) => r.timings.duration < 1000,
      });
    });
  });

  group(`${baseURL} - Por ID`, function () {
    const endpoints = ['user', 'registry', 'address', 'customer'];
    
    endpoints.forEach(endpoint => {
      const res = http.get(`${baseURL}/${endpoint}/${testId}`);
      check(res, {
        [`${endpoint}/{id} - status 200`]: (r) => r.status === 200,
        [`${endpoint}/{id} - tempo < 500ms`]: (r) => r.timings.duration < 500,
      });
    });
  });
}

export default function () {
  testEndpoints(dotnetBaseURL);
  testEndpoints(javaBaseURL);
}

export function handleSummary(data) {
  return {
    'api-stress-test.html': htmlReport(data),
    stdout: textSummary(data, { indent: ' ', enableColors: true }),
  };
}