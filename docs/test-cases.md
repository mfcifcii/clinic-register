# Test Cases — Clinic Register

## TC-01: Register page loads
**Precondition:** App is running  
**Steps:**
1. Navigate to `/register`  
**Expected:** The registration form fields are visible (Name, Surname, Phone Number, Email)


## TC-02: Validation errors on invalid input
**Steps:**
1. Navigate to `/register`
2. Submit with:
   - name: empty
   - surname: empty
   - phoneNumber: `123`
   - email: `abc`
**Expected:** The user stays on the registration page and validation error messages are displayed for the invalid fields.

## TC-03: Successful registration (happy path)
**Steps:**
1. Navigate to `/register`
2. Submit with valid values  
**Expected:** Result page is displayed and `patientNo` is shown

## TC-04: Patients list shows registered patient
**Steps:**
1. Complete TC-03
2. Navigate to `/patients`  
**Expected:** Newly registered patient appears in the list

## TC-05: In-memory persistence behavior
**Steps:**
1. Complete TC-03
2. Restart application
3. Navigate to `/patients`  
**Expected:** Previously registered patients are not present (known limitation)
