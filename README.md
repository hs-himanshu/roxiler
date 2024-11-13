# API Description
# Transactions API Documentation

## API Endpoints

### 1. Get All Transactions
Retrieve all transactions for a specified month, with pagination.

- **URL:** `GET http://localhost:7000/api/v1/transactions`
- **Query Parameters:**
  - `month` (integer): Month for which transactions are retrieved (e.g., `5` for May)
  - `page` (integer): Page number for pagination (e.g., `1`)
  - `size` (integer): Number of items per page (e.g., `10`)

**Example Request:**
http
GET http://localhost:7000/api/v1/transactions?month=5&page=1&size=10

### 2. Initialize Transactions
Initialize the transactions database with sample data.
- **URL:** `GET http://localhost:7000/api/v1/database/init`

**Example Request:**
- **URL:** `GET http://localhost:7000/api/v1/database/init`

### 3. Statistics
Retrieve transaction statistics for a specified month.
- **URL:** `GET http://localhost:7000/api/v1/transactions/statistics`
- **Query Parameters:**
  - `month` (integer): Month for which statistics are retrieved (e.g., 2 for February)
**Example Request:**
- **URL:** `GET http://localhost:7000/api/v1/transactions/statistics?month=2`

### 3. Bar Chart Data
Retrieve data for generating a bar chart based on transactions in a specified month.
- **URL:** `GET http://localhost:7000/api/v1/transactions/bar-chart`
- **Query Parameters:**
  - `month` (integer): Month for which bar chart data is retrieved (e.g., 2 for February)
**Example Request:**
- **URL:** `GET http://localhost:7000/api/v1/transactions/bar-chart?month=2`

### 3. Combined Data
Retrieve combined data for various transaction insights for a specified month.
- **URL:** `GET http://localhost:7000/api/v1/transactions/combined-data`
- **Query Parameters:**
  - `month` (integer): Month for which combined data is retrieved (e.g., 2 for February)
**Example Request:**
- **URL:** `GET http://localhost:7000/api/v1/transactions/combined-data?month=2`

##Notes
Ensure the API server is running on http://localhost:7000.
