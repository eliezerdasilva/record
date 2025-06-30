using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace YourNamespace.Models
{
    [Table("user")]
    public class User
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [JsonIgnore]
        public long Id { get; set; }

        [Required]
        [StringLength(200, MinimumLength = 5)]
        [JsonPropertyName("name")]
        public string Name { get; set; } = string.Empty;

        [Required]
        [Column("User_category")]
        [JsonPropertyName("userCategory")]
        public string UserCategory { get; set; } = string.Empty;

        [Required]
        [Column("cpf")]
        [JsonPropertyName("cpf")]
        public int Cpf { get; set; }

        [Required]
        [EmailAddress]
        [Column("email")]
        [JsonPropertyName("email")]
        public string Email { get; set; } = string.Empty;

        [Required]
        [Column("Date_Birth")]
        [JsonPropertyName("dateBirth")]
        public DateTime DateBirth { get; set; }

        [ForeignKey("endereco_id")] // Nome da coluna no banco
        public Address Address { get; set; } = new Address();
    }
}