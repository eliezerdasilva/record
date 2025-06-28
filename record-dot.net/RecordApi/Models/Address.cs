using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace YourNamespace.Models
{
    [Table("address")]
    public class Address
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Required]
        public int Cep { get; set; }

        [Required]
        [MinLength(1)]
        public string State { get; set; }

        [Required]
        [MinLength(1)]
        public string City { get; set; }

        [Required]
        [MinLength(1)]
        public string Neighborhood { get; set; }

        [Required]
        [MinLength(1)]
        public string Road { get; set; }

        [Required]
        [MinLength(1)]
        public string HouseNumber { get; set; }
    }
}
