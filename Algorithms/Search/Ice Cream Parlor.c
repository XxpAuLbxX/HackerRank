#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef int boolean;
#define true 1
#define false 0

// A utility function to swap two elements
void swap(int* a, int* b)
{
    int t = *a;
    *a = *b;
    *b = t;
}
 
/* This function takes last element as pivot, places the pivot element at its correct position in sorted array, 
   and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot */
int partition (int arr[], int low, int high)
{
    int pivot = arr[high];    // pivot
    int i = (low - 1);  // Index of smaller element
 
    for (int j = low; j <= high- 1; j++)
    {
        // If current element is smaller than or equal to pivot
        if (arr[j] <= pivot)
        {
            i++; // increment index of smaller element
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}
 
// The main function that implements QuickSort: arr[] = Array to be sorted, low = Starting index, high = Ending index 
void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        // pi is partitioning index, arr[p] is now at right place
        int pi = partition(arr, low, high);
 
        // Separately sort elements before partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

/* Function to print an array */
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main(){
    int T, M, N;
    boolean minFlag, maxFlag;
    scanf("%d",&T);
    for(int i=0; i < T; i++) {
        scanf("%d", &M);
        scanf("%d", &N);
        int Price[N], sortedPrice[N], min = 0, max = N-1;
        minFlag = 0, maxFlag = 0;
        // Place prices in array
        for(int j=0; j < N; j++) {
            scanf("%d", &Price[j]);
        }
        // Copy array to be destroyed when sorting
        memcpy(sortedPrice, Price, sizeof(sortedPrice));
        quickSort(sortedPrice, 0, N-1);
        //printArray(sortedPrice, N);
        // loop that finds elements in O(n) time by getting lower or higher value of sorted array
        for(int j=0; j < N; j++) {
            // gets lower value if total is above expected sum
            if((sortedPrice[min] + sortedPrice[max]) > M)
                max--;
            // gets higher value if total is below expected sum
            else if((sortedPrice[min] + sortedPrice[max]) < M)
                min++;
            // elements found, so linear search through original array to find indexes
            else {
                min = sortedPrice[min];
                max = sortedPrice[max];
                int k = 0;
                // loops while both aren't found and they haven't all been checked
                while(!(minFlag && maxFlag) && k < N) {
                    if(!minFlag && (Price[k] == min)) {
                        minFlag = 1;
                        min = k+1; 
                    // else if allows only the first to be chosen if values are equal
                    } else if(!maxFlag && (Price[k] == max)) {
                        maxFlag = 1;
                        max = k+1;
                    }
                    k++;
                }
				// prints lowest first
                if(min > max) 
                    printf("%d %d\n", max, min);
                else 
                    printf("%d %d\n", min, max);
                break; // break out when solution is found
            }
                
        }
    }
    return 0;
}