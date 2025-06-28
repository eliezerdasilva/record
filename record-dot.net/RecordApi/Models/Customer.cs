using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace RecordApi.Models
{
    [Table("customer")]
    public class Customer
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Required]
        [StringLength(200, MinimumLength = 5)]
        public string Name { get; set; } = string.Empty;

        [Required]
        [MinLength(11)]
        public string Fone { get; set; } = string.Empty;

        [Required]
        [Column(TypeName = "varchar(255)")]
        public string Cnpj { get; set; } = string.Empty;

        [Required]
        public bool Company_Regular { get; set; }
    }
}
