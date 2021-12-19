# android-fizzbuzz

## Subject 

Write a simple fizz-buzz application.
The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing :
- all multiples of **3** by **"fizz"**,
- all multiples of **5** by **"buzz"**,
- and all multiples of **15** by **"fizzbuzz"**.

The output would look like this: **"1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,..."**.
Your goal is to implement an application that :
- **[first screen]** Have a form that accepts five parameters : three integers `int1`, `int2` and `limit`, and two strings `str1` and `str2`.
- **[second screen]** Display a scrollable screen with a list of strings with numbers from 1 to `limit`, where: all multiples of `int1` are replaced by
`str1`, all multiples of `int2` are replaced by `str2`, all multiples of `int1` and `int2` are replaced by `str1 + str2`.

## Solution

This git repository is a possible solution of the problem above. Here are the screenshots of the form page and the scrollable screen result :

<img src="https://github.com/davinh2306/android-fizzbuzz/blob/main/form_screen.png" width="200" /> <img src="https://github.com/davinh2306/android-fizzbuzz/blob/main/result_screen.png" width="200" />

### Form Page explanation

Nothing special here : we only have a classic form which accepts only numbers for `limit`, `firstMultiple` and `secondMultiple`. `fizz` and `buzz` have more freedom as you can type everything you want.

When you click on the CTA at the bottom of the screen, you will be redirected to the Result Page with elements from your form. If nothing is entered by the user, the default value will be used.

### Result Page explanation

As you can see in the code, I decided to directly calculate the result in `RecyclerView.onBindViewHolder` depending on the user's position on the list. 
I have noticed that I do not need to generate the whole result list from 1 to limit (no matter how big it can be) because we only have to display a small part of the result list (except if you have a 1 kilometer smartphone screen). 
So in order to guarantee performance and stability the result list is generated progressively when you scroll. Thanks to RecyclerView the reuse of old views improves performance and app's responsiveness event with large sets of data. In the end, we only have small modulo-calculations so we do not need to seperate it from the Main Thread.

### Test

I decided to test the class `FizzBuzz` because it is the class that guarantees the proper functioning of the FizzBuzz result list. 

### Improvement

Here are some improvements that could be great for the application :
- Improve the UI (of the form and the result display) and change the color palette
- Add a logo for the application
- Add some UI tests to check if the form is well designed (e.g. only numbers for the limit and multiples)
- create a dimens.xml in order to store padding, margin and size values
- Use view binding in ResultAdapter
