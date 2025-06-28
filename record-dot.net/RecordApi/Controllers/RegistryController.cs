using System.Collections.Generic;
using System.Threading.Tasks;
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
        public async Task<ActionResult<IEnumerable<Registry>>> GetRegistry()
        {
            var registries = await _service.ListarRegistry();
            return Ok(registries);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Registry>> GetRegistryById(long id)
        {
            var registry = await _service.BuscarPorId(id);
            if (registry == null)
            {
                return NotFound();
            }
            return Ok(registry);
        }

        [HttpPost]
        public async Task<ActionResult<Registry>> CreateRegistry([FromBody] Registry dto)
        {
            await _service.CriarRegistry(dto);
            return CreatedAtAction(nameof(GetRegistryById), new { id = dto.Id }, dto);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateRegistry(long id, [FromBody] Registry dto)
        {
            if (id != dto.Id)
            {
                return BadRequest("ID no corpo não corresponde ao ID na URL.");
            }

            var atualizado = await _service.AtualizarRegistry(dto);
            if (!atualizado)
            {
                return NotFound();
            }

            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRegistry(long id)
        {
            var removido = await _service.RemoverRegistry(id);
            if (!removido)
            {
                return NotFound();
            }

            return NoContent();
        }
    }
}
