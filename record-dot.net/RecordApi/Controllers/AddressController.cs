using Microsoft.AspNetCore.Mvc;
using RecordApi.Models;
using RecordApi.Services;
using System.Collections.Generic;
using System.Threading.Tasks;
using YourNamespace.Models;

namespace RecordApi.Controllers
{
    [ApiController]
    [Route("api/address")]
    public class AddressController : ControllerBase
    {
        private readonly AddressService _addressService;

        public AddressController(AddressService addressService)
        {
            _addressService = addressService;
        }

        // GET: api/address
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Address>>> GetAll()
        {
            var addresses = await _addressService.ListAllAsync();
            return Ok(addresses);
        }

        // GET: api/address/{id}
        [HttpGet("{id}")]
        public async Task<ActionResult<Address>> GetById(long id)
        {
            var address = await _addressService.GetByIdAsync(id);
            if (address == null)
                return NotFound();

            return Ok(address);
        }

        // POST: api/address
        [HttpPost]
        public async Task<ActionResult<Address>> Create(Address address)
        {
            var createdAddress = await _addressService.CreateAsync(address);
            return CreatedAtAction(nameof(GetById), new { id = createdAddress.Id }, createdAddress);
        }

        // PUT: api/address/{id}
        [HttpPut("{id}")]
        public async Task<IActionResult> Update(long id, Address address)
        {
            if (id != address.Id)
                return BadRequest();

            await _addressService.UpdateAsync(address);
            return NoContent();
        }

        // DELETE: api/address/{id}
        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(long id)
        {
            var address = await _addressService.GetByIdAsync(id);
            if (address == null)
                return NotFound();

            await _addressService.DeleteAsync(id);
            return NoContent();
        }
    }
}