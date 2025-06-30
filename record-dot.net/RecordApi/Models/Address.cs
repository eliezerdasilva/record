using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace YourNamespace.Models
{
    [Table("address")]
    public class Address
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Required]
        [JsonPropertyName("cep")] // Mapeia para o nome no JSON
        public int Cep { get; set; }

        [Required, MinLength(1)]
        [JsonPropertyName("state")]
        public string State { get; set; } = string.Empty;

        [Required, MinLength(1)]
        [JsonPropertyName("city")]
        public string City { get; set; } = string.Empty;

        [Required, MinLength(1)]
        [JsonPropertyName("neighborhood")]
        public string Neighborhood { get; set; } = string.Empty;

        [Required, MinLength(1)]
        [JsonPropertyName("road")]
        public string Road { get; set; } = string.Empty;

        [Required, MinLength(1)]
        [Column("House_Number")]
        [JsonPropertyName("houseNumber")] // Mantém o padrão camelCase no JSON
        public string HouseNumber { get; set; } = string.Empty;
    }
}