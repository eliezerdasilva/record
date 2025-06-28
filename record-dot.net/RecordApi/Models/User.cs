using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using RecordApi.Models;

namespace YourNamespace.Models
{
   
    [Table("user")]
    public class User
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Required]
        [StringLength(200, MinimumLength = 5)]
        public string Name { get; set; }

        
        [Required]
        [Column("cpf")]
        public int Cpf { get; set; } // Atenção: Cpf como int pode ser problemático se for número grande, considere string

        [Required]
        [EmailAddress]
        [Column("email")]
        public string Email { get; set; }

        [Required]
        public DateTime DateBirth { get; set; }

        [Required]
        public Address Address { get; set; } // Relacionamento 1:1 será configurado no DbContext
 
    }
}
