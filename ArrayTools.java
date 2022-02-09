/*
Student name: Shiva Rama Krishna Nutakki
Student id : A00245380
Program description: This program gives the user four options which are Ceasar cipher,
                     search an element in the array, Average of the array and reverse the string.

*/
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.lang.*;

public class ArrayTools{

  public static void main(String args[]){

    Scanner choiceInput = new Scanner(System.in);// Scanner object is generated.


    System.out.println("Choose any one: \n 1. Caesar Cipher \n2. Average of given numbers \n3. Find a number \n4. Reverse the array of numbers");//Displays the list.
    int choice = choiceInput.nextInt();

    int i,search;
    int a[]=new int[100];//Array are declared.

    switch(choice){
      case 1:
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the String for Encryption: ");
      String text = new String();
      text = scan.next();//Encrypts the user input.
      System.out.print("Enter the value of shift key:");
      int key=scan.nextInt();//For the ceaser cypher algorithm, we take input from user and use it as a shiftkey.
      System.out.println("The encrypted String: "+caesarCipher(text, key));//Prints encrypt cipher text.
      System.out.println("\ndecrypting\t"+caesarCipher(text, key));//Prints decrypts the cipher text.
            System.out.println("\nAfter decryption : "+decrypt(caesarCipher(text, key), key));//Printing the DECRYPTED text.

      break;
      case 2:
      Scanner scan2 = new Scanner(System.in);
     System.out.print("Enter no of elements:");
      int n=scan2.nextInt();//Takes input from user to enter the elements.
      System.out.println("enter elements of the array");
      for(i=0;i<n;i++)
      {
        a[i]=scan2.nextInt();//User enters the elememts of array.
      }
      System.out.println(" Elements of the array are");
      for(i=0;i<n;i++)
      {
        System.out.print("\t"+a[i]);// Prints users entered elements of array.
      }
      System.out.println();
      arrayAvg(a,n);

      break;
      case 3:
      Scanner scan3 = new Scanner(System.in);
     System.out.print("Enter no of elements:");
    int m=scan3.nextInt();//User enters the elements.
      System.out.println("enter elements of the array");
      for(i=0;i<m;i++)
      {
        a[i]=scan3.nextInt();
      }
      System.out.println(" Elements of the array are");
      for(i=0;i<m;i++)
      {
        System.out.print("\t"+a[i]);//The array elements are printed.
      }
      System.out.println();
      System.out.print("enter an element to be searched:");
      search = scan3.nextInt();//User enters an element to search.
      arrayContains(a,m,search);

      break;
      case 4:
      Scanner scan4 = new Scanner(System.in);
      System.out.print("Enter no of elements:");
      int  l=scan4.nextInt();// Taking no of elements from the user.
      System.out.println("enter elements of the array");
      for(i=0;i<l;i++)
      {
        a[i]=scan4.nextInt();//Requesting the Elements of an array.
      }
      System.out.println(" Elements of the array are");
      for(i=0;i<l;i++)
      {
        System.out.print("\t"+a[i]);//  Here it prints the elements of array.
      }
      System.out.println();
      System.out.println("The reverse array is ");
      reverse(a,l);//Taking reverse method to print reverse of the array.
      break;
      default:
      System.out.println("Invalid choice...please try again");
      break;}

  }



    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

      public static String caesarCipher(String plainText, int shiftKey)
     {
      plainText = plainText.toLowerCase();//Converts the text into lowercase
      String cipherText = "";
      for (int i = 0; i < plainText.length(); i++)
      {
          int charPos = ALPHABET.indexOf(plainText.charAt(i));//Obtaining the numeric value of corresponding character.
          int keyVal = (shiftKey + charPos) % 26;// With shiftkey obtaining the resultant position.
          char replaceVal = ALPHABET.charAt(keyVal);// By using the code obtaining the replacing  character.
          cipherText += replaceVal;//Allocation of resultant character to the cipher text.
      }
      return cipherText;//Returns the cipher text.
  }
  public static String decrypt(String cipherText, int shiftKey)
  {
      cipherText = cipherText.toLowerCase();//Converts the text into lowercase.
      String plainText = "";
      for (int i = 0; i < cipherText.length(); i++)
      {
          int charPos = ALPHABET.indexOf(cipherText.charAt(i));
          int keyVal = (charPos - shiftKey) % 26;
          if (keyVal < 0)
          {
              keyVal = ALPHABET.length() + keyVal;
          }
          char replaceVal = ALPHABET.charAt(keyVal);
          plainText += replaceVal;//The resultant character are attributed to plainText.
      }
      return plainText;//Returns the plain text.
    }


    public static void arrayAvg(int[] a,int n)//In this method,It calculates the average of the array elements.
    {
      int i;
      double sum=0.0,avg;
      for(i=0;i<n;i++)
      {
        sum = sum + a[i];
      }
      avg=sum/n;
      System.out.println("The Average of array=" + avg);//Prints the average result.
    }


    public static void arrayContains(int a[],int n,int k)//In this method,it finds the element that is  present in the array.
    {
      int i,flag=0;
      for(i=0;i<n;i++)//The LINEAR SEARCH is the algorithm used to find an element.
      {
        if(a[i]==k)
        {
         System.out.println("The array contains " + a[i] + "at" + i);//If an element is detected, it is printed with its position.
         flag=1;
         break;
       }
     }
          if(flag==0)
             System.out.println("The array does not contain " + k);// Prints the element if it is not found in the list.

    }

    public static void reverse(int a[],int n)// Prints the arrays in reverse order.
    {
      int i;
      System.out.print("[\t");
      for(i=n;i>0;i--)//The loop runs in the opposite direction of the original arrangement.
      {
        System.out.print( a[i-1] + "\t");
      }
      System.out.println("]");
    }
}
