# UI Automation Testing with Selenium WebDriver: BookCart

Welcome to the BookCart UI Automation Testing Repository! This project is all about showcasing how we can automate the testing of key features on the BookCart website https://bookcart.azurewebsites.net/ using Selenium WebDriver. Whether you're new to UI automation or looking to enhance your skills, this repo offers a step-by-step guide to ensure the BookCart website functions flawlessly.
## 🚀 Key Features Tested:

Here are the core features we've automated test cases for:
- **Registration**
- **Login**
- **Search Book**
- **Book Details**
- **Add to Cart (Main Page)**
- **Add to Cart (Detail Page)**
- **Checkout**

## 📋 Test Cases Breakdown:
### 1️⃣ Registration
**Goal:** Ensure users can successfully create a new account.  
**Steps:**
- Navigate to the registration page.
- Enter valid details (First Name, Last Name, Username, Password).
- Submit the form and confirm successful registration.
- Redirect to the login page for further interaction.


### 2️⃣ Successful Login
**Goal:** Verify that users can log in with valid credentials.  
**Steps:**
- Visit the login page.
- Enter valid credentials (username and password).
- Click login and check for successful redirection.
   
### 3️⃣ Search Book
**Goal:** Test the search functionality and display accurate results.  
**Steps:**
- Go to the search bar on the main page.
- Enter a book title and submit.
- Validate that the search results display relevant books.

### 4️⃣ Book Details
**Goal:** Confirm users can view detailed book information.  
**Steps:**
- Browse the dashboard or main page.
- Click a book's title.
- Ensure the details page displays relevant information like title, price, author, etc.
   
### 5️⃣ Add to Cart from Main Page
**Goal:** Ensure users can add books to their cart directly from the main page.  
**Steps:**
- Navigate to the main page.
- Click the "Add to Cart" button on a listed book.
- Verify the book is added to the shopping cart.

### 6️⃣ Add to Cart from Detail Page
**Goal:** Allow users to add a book to the cart from the detailed view.  
**Steps:**
- Visit the book details page.
- Click the "Add to Cart" button on the Book Details section.
- Add a book from the Similar Books section too.
- Check if both books are added to the cart.
   
### 7️⃣ Checkout
**Goal:** Verify that users can proceed with the checkout process.  
**Steps:**
- Add one or more books to the cart.
- Navigate to the checkout page.
- Click the checkout button and validate the process.

## 🎯 Objectives
1. **Learning Automation Testing Fundamentals:** Gain hands-on experience automating key UI test cases for a web application using Selenium WebDriver, which is widely used in the industry.
2. **Testing Core Features:** The project provides a comprehensive list of features to automate, such as registration, login, search, viewing book details, adding to cart, and checkout. By automating these, it will ensure that these core features work flawlessly on the BookCart website.
3. **Improving Test Efficiency:** By automating these tests, you’ll see how automated testing can increase the speed of testing, reduce human error, and make it easier to run tests across multiple browsers.
