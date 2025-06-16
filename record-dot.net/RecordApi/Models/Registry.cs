using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace RecordApi.Models
{
    public class Registry
    {
        public long Id { get; set; }
        public string Description { get; set; }
        public DateTime Date { get; set; }
    }
}
