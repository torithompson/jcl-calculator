# JCL Calculator

The JCL Calculator is a simple tool that allows you to calculate the DCB and space parameters for block size, cylinder, and track space allocations in JCL (Job Control Language).

## Features

- **Block Size Calculation**:
  - Calculate DCB parameters, including LRECL, BLKSIZE, and RECFM, based on your input.
  - Determine space allocations for block size with or without minimum and maximum records.

- **Cylinder and Track Space Calculation**:
  - Calculate space parameters for cylinder and track allocations in JCL.
  - Handle both cases with and without maximum limits.

## Getting Started

Follow these steps to use the JCL Calculator:

1. **Clone the Repository**:
   Clone this repository to your local environment.

2. **Run the Application**:
   Execute the Spring Boot application. You can run it using your favorite IDE or by running the JAR file.

3. **Access the Calculator**:
   Open your web browser and navigate to `http://localhost:8080` (or the appropriate URL where your application is running).

4. **Calculate Parameters**:
   Input the required values and calculate the DCB and space parameters based on your specific needs.

## Usage

### Block Size Calculation

1. Input the file size (LRECL)
2. Specify the blocking factor
3. Click "Calculate Block Size."
4. input min records
5. optionally input max records
6. calculate block space

### Cylinder and Track Space Calculation

1. Input the minimum number of cylinders or tracks.
1. Optionally, input the maximum number of cylinders or tracks if applicable.
1. Click "Calculate Cylinder Size" or "Calculate Track Size."

## Contributions

Contributions are welcome. If you have ideas for improvements or new features, feel free to create a pull request.

Enjoy using the JCL Calculator for your JCL calculations!
