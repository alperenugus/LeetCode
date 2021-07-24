/*

    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

    Follow up: The overall run time complexity should be O(log (m+n)).

*/

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    
    let mergedArray = [];
    
    while(nums1.length > 0 || nums2.length > 0){
        
        let first;
        let second;

        let both = nums1.length > 0 && nums2.length > 0;

        if(both && nums1[0] <= nums2[0]) mergedArray.push(nums1.shift());
        else if(both && nums1[0] > nums2[0]) mergedArray.push(nums2.shift());
        else if(nums1.length > 0) mergedArray.push(nums1.shift());
        else mergedArray.push(nums2.shift());
    }

    if(mergedArray.length == 1) return mergedArray[0];

    let mid = mergedArray.length / 2;

    if(mergedArray.length % 2 === 1) return mergedArray[Math.floor(mid)];
    else return (mergedArray[(mid) - 1] + mergedArray[mid]) / 2;   
};