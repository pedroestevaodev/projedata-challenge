# Projedata Junir Software Developer Challenge

<p style="text-align: center; display: block; margin: 0 auto;">
    <a href="https://www.pedroestevao.com">
        <img src="https://res.cloudinary.com/dge3g9rcw/image/upload/v1755645513/logo-projedata_uwvhzc.webp" alt="Illustrative image" style="display: block; margin: 0 auto;" />
    </a>
</p>

This project is a **Java console application** developed as a programming exercise to manage employee data. It covers inheritance, collections, formatting, and grouping in Java, demonstrating **object-oriented programming** and **best practices**.

## Key Features

* **Class Hierarchy:**

  * `Pessoa` → base class with `nome` and `dataNascimento`.
  * `Funcionario` → extends `Pessoa`, adding `salario` and `funcao`.
* **Data Insertion:** All employees are inserted in the same order as a predefined table.
* **Remove Employee:** Removes an employee by name.
* **Formatted Output:**

  * Dates displayed as `dd/MM/yyyy`.
  * Salaries displayed with thousand separators (`1.000,00`).
* **Salary Adjustment:** All employees receive a 10% salary increase.
* **Grouping:** Employees are grouped by job function using a `Map<String, List<Funcionario>>`.
* **Filtering:** Lists employees with birthdays in October (10) and December (12).
* **Oldest Employee:** Displays the name and age of the oldest employee.
* **Sorting:** Employees listed in alphabetical order.
* **Aggregations:**

  * Total sum of all salaries.
  * Comparison of salaries to the minimum wage (R\$ 1212,00).

## Tech Stack

This project was built using:

* **Java 17+** (recommended: Java 24 LTS).
* **IntelliJ IDEA Community Edition** for development.
* **Collections API (List, Map, Streams)**.
* **BigDecimal** for precise salary calculations.
* **DateTime API (java.time.LocalDate)** for modern date handling.

## Setup & Installation

### 1. Clone the repository

```bash
git clone https://github.com/pedroestevaodev/projedata-challenge.git
cd projedata-challenge
```

### 2. Open in IntelliJ IDEA

* Open IntelliJ IDEA.
* Click **File > Open** and select the project folder.
* Make sure the JDK version is set to Java 17 or higher.

### 3. Run the Project

* Navigate to `src/br/com/empresa/Principal.java`.
* Right-click the file and select **Run 'Principal.main()'**.
* The console will display the outputs for all tasks.

## Available Commands

| Action                | Description                                                    |
| --------------------- | -------------------------------------------------------------- |
| Insert Employees      | Populates the list with employees from the predefined dataset. |
| Remove Employee       | Removes an employee by name.                                   |
| Print Employees       | Displays all employees in a formatted table.                   |
| Salary Increase       | Applies a 10% raise to all employees.                          |
| Group by Function     | Groups employees by their role.                                |
| Filter by Birth Month | Lists employees with birthdays in October and December.        |
| Oldest Employee       | Displays the employee with the highest age.                    |
| Alphabetical Order    | Sorts employees alphabetically by name.                        |
| Total Salaries        | Shows the sum of all employee salaries.                        |
| Salary in Min Wages   | Displays how many minimum wages each employee earns.           |

## Best Practices Followed

* **Encapsulation:** Attributes kept private, accessed via getters/setters.
* **Inheritance:** Reuse of properties and methods through `Pessoa` → `Funcionario`.
* **Immutability for Money:** Salaries handled with `BigDecimal`.
* **Locale & Formatting:** Brazilian locale (`pt-BR`) for numbers and dates.
* **Streams API:** Used for filtering, sorting, and grouping for performance and readability.
* **Separation of Concerns:** Each method performs a single, well-defined task.
* **Error Handling:** Safe removal with `removeIf`, avoiding exceptions.

## Performance Considerations

* **Streams & Lambdas:** Used for efficient iteration and grouping.
* **BigDecimal:** Ensures salary calculations are accurate (avoiding floating-point errors).
* **DateTime API:** Provides efficient and thread-safe date operations.
* **`removeIf`:** Avoids manual loops, improving readability and performance.

## License

This project is open source and available under the [MIT License](https://mit-license.org/).
<br />

---

<br />
**Built with ☕ and 💻 for learning and best practices in Java.**
