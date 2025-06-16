using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using RecordApi.Models;
using RecordApi.Services;

namespace RecordApi.Controllers
{
    [ApiController]
    [Route("api/registry")]
    public class RegistryController : ControllerBase
    {
        private readonly RegistryService _service;

        public RegistryController(RegistryService service)
        {
            _service = service;
        }

        [HttpGet]
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Registry>>> GetRegistry()
        {
            var registries = await _service.ListarRegistry();
            return Ok(registries);
        }
        [HttpPost]
        public ActionResult<Registry> CreateRegistry([FromBody] Registry dto)
        {
            var registry = _service.CriarRegistry(dto);
            return CreatedAtAction(nameof(GetRegistry), new { id = registry.Id }, registry);
        }
    }
}
