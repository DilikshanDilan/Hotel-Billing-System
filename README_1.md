# Hotel Billing System (Java)

A simple console-based Hotel Billing System written in Java, demonstrating core Object-Oriented Programming concepts through a practical billing workflow: customer registration, room selection, extra services, and final bill generation with tax and discount.

This is a group project.

## Contributors

- Name 1
- Name 2
- Name 3
- Name 4

*(Update the names above with your group members before uploading.)*

## Features

- Capture customer details (name, contact, check-in/check-out dates)
- Choose from 4 room types with per-day pricing:
  | Room Type | Rate (per day) |
  |-----------|-----------------|
  | Single    | Rs. 3,000       |
  | Double    | Rs. 5,000       |
  | Deluxe    | Rs. 8,000       |
  | Suite     | Rs. 12,000      |
- Add extra service charges (food, laundry, room service)
- Automatic 10% tax calculation
- Room-type-based discount applied automatically
- Formatted final bill summary
- Input validation with re-prompting for invalid or out-of-range values

## Project Structure

```
.
├── HotelBillingSystemProject.java   # Main source file
└── README.md
```

### Class Overview

| Class     | Responsibility                                             |
|-----------|--------------------------------------------------------------|
| `Customer`| Stores and displays customer details                         |
| `Room`    | Stores room type/duration and calculates room charges        |
| `Services`| Stores and totals extra service charges                      |
| `Bill`    | Calculates tax, applies discount, and prints the final bill  |
| `HotelBillingSystemProject` | Entry point; handles user input and program flow |

## Requirements

- Java Development Kit (JDK) 8 or later

## How to Compile & Run

```bash
# Compile
javac HotelBillingSystemProject.java

# Run
java HotelBillingSystemProject
```

## Sample Run

```
======= HOTEL BILLING SYSTEM =======
Enter Customer Name: Dilan Perera
Enter Contact Number: 0771234567
Enter Check-in Date (YYYY-MM-DD): 2026-08-01
Enter Check-out Date (YYYY-MM-DD): 2026-08-05

-- Customer Details --
Customer Name  : Dilan Perera
Contact Number : 0771234567
Check-in Date  : 2026-08-01
Check-out Date : 2026-08-05

Select Room Type:
1. Single - Rs. 3000/day
2. Double - Rs. 5000/day
3. Deluxe - Rs. 8000/day
4. Suite  - Rs. 12000/day
Enter option (1-4): 3
Enter Number of Days Stayed: 4

-- Room Details --
Room Type      : Deluxe
Days Stayed    : 4
Room Charges   : Rs. 32000

Enter Service Charges:
Food Charges: Rs. 1500
Laundry Charges: Rs. 800
Room Service Charges: Rs. 500

-- Extra Services --
Food           : Rs. 1500
Laundry        : Rs. 800
Room Service   : Rs. 500
Service Total  : Rs. 2800

------- FINAL BILL -------
Subtotal        : Rs. 34800.00
Tax (10%)       : Rs. 3480.00
Discount        : Rs. 1500.00
-----------------------------
TOTAL BILL      : Rs. 36780.00
=============================
Thank you for staying with us!
```

## Notes / Improvements Made

This version fixes a few robustness issues found in the original draft:
- Validates all inputs (name/contact/dates can't be blank; numeric fields must be within a sensible range) and re-prompts instead of crashing on bad input
- Formats currency values to 2 decimal places instead of raw doubles (e.g. `3480.00` instead of `3480.0`)
- Closes the `Scanner` safely via a `finally` block
- Wraps the flow in a `try/catch` to fail gracefully on unexpected input errors

## Possible Future Enhancements

- Persist bills to a file or database
- Support multiple rooms/bookings per customer
- Add a GUI (JavaFX/Swing) or convert to a web app
- Export the final bill as a PDF

## License

This project is open for educational use. Feel free to fork and adapt it for coursework or personal projects.
