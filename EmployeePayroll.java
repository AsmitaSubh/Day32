using System;
using System.Data;
using System.Data.SqlClient;

namespace AddressBookApp
{
    class Program
    {
        static void Main(string[] args)
        {
            string connectionString = "your_connection_string_here";

            // Connect to the database
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();

                // Insert a new contact
                using (SqlCommand command = new SqlCommand("INSERT INTO Contact (ID, Name, Phone, Email) VALUES (@ID, @Name, @Phone, @Email)", connection))
                {
                    command.Parameters.AddWithValue("@ID", 3);
                    command.Parameters.AddWithValue("@Name", "Michael Johnson");
                    command.Parameters.AddWithValue("@Phone", "7890123456");
                    command.Parameters.AddWithValue("@Email", "michael.johnson@example.com");
                    command.ExecuteNonQuery();
                }

                // Retrieve all contacts
                using (SqlCommand command = new SqlCommand("SELECT * FROM Contact", connection))
                {
