# Company Management Database README

This script creates a MySQL database named `company_management_db` for managing employees, contracts, family members, and services. Auto-increment is used for primary keys, and foreign keys maintain relationships. Transactions ensure data integrity.

## Script Overview:

1. **Database creation:** Drops `company_management_db` if it exists and then creates it.

2. **Table definitions:** Defines tables for employees, contracts, family members, services, and employee_services.

3. **Auto-increment:** Primary keys (employee_id, contract_id, etc.) are auto-incremented for uniqueness.

4. **Foreign key constraints:** Establishes relationships between tables for data integrity.

5. **Transactions:** Uses transactions to ensure consistent data and rollback on
