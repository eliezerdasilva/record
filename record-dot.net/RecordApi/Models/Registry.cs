using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace RecordApi.Models
{
    [Table("registry")]
    public class Registry
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Column("data")]
        public DateTime Data { get; set; }

        [Column("value")]
        public double Value { get; set; }

        [Column("paid")]
        public bool Paid { get; set; }

        [Column("collection_point")]
        public string CollectionPoint { get; set; } = string.Empty;

        [Column("delivery_location")]
        public string DeliveryLocation { get; set; } = string.Empty;

        [ForeignKey("Customer")]
        [Column("customer_id")]
        [JsonIgnore]
        public long CustomerId { get; set; }

        public Customer? Customer { get; set; }
    }
}
