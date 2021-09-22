cmake_minimum_required(VERSION 3.19)
project(cpp)

set(CMAKE_CXX_STANDARD 14)

add_executable(cpp
        Array/1002.FindCommonCharacters.cpp
        Array/1010.PairsofSongsWithTotalDurationsDivisibleby60.cpp
        Array/1013_PartitionArrayIntoThreePartsWithEqualSum.cpp
        Array/1018_BinaryPrefixDivisibleBy5.cpp
        Array/1051_HeightChecker.cpp
        Array/106.ConstructBinaryTreefromInorderandPostorderTraversal.cpp
        Array/1089.DuplicateZeros.cpp
        Array/1122_RelativeSortArray.cpp
        Array/1184_DistanceBetweenBusStops.cpp
        Array/118_Pascal'sTriangle.cpp
        Array/119_Pascal'sTriangleII.cpp
        Array/1200.MinimumAbsoluteDifference.cpp
        Array/1232.CheckIfItIsaStraightLine.cpp
        Array/1266.MinimumTimeVisitingAllPoints.cpp
        Array/1295_FindNumberswithEvenNumberofDigits.cpp
        Array/1304.FindNUniqueIntegersSumuptoZero.cpp
        Array/1337.TheKWeakestRowsinaMatrix.cpp
        Array/154_FindMinimuminRotatedSortedArrayII.cpp
        Array/162_FindPeakElement.cpp
        Array/167_TwoSumII-Inputarrayissorted.cpp
        Array/209_MinimumSizeSubarraySum.cpp
        Array/216.CombinationSumIII.cpp
        Array/217_ContainsDuplicate.cpp
        Array/219_ContainsDuplicateII.cpp
        Array/225_ImplementStackusingQueues.cpp
        Array/228.SummaryRanges.cpp
        Array/229.MajorityElementII.cpp
        Array/238.ProductofArrayExceptSelf.cpp
        Array/3_LongestSubstringWithoutRepeatingCharacters.cpp
        Array/40.CombinationSumII.cpp
        Array/414_ThirdMaximumNumber.cpp
        Array/442.FindAllDuplicatesinanArray.cpp
        Array/448_FindAllNumbersDisappearedinanArray.cpp
        Array/485_MaxConsecutiveOnes.cpp
        Array/509_FibonacciNumber.cpp
        Array/5344.HowManyNumbersAreSmallerThantheCurrentNumber.cpp
        Array/5348.FindtheDistanceValueBetweenTwoArrays.cpp
        Array/53_MaximumSubarray.cpp
        Array/54_SpiralMatrix.cpp
        Array/55_JumpGame.cpp
        Array/561_ArrayPartitionI.cpp
        Array/566_ReshapetheMatrix.cpp
        Array/56_MergeIntervals.cpp
        Array/57.InsertInterval.cpp
        Array/583_DeleteOperationforTwoStrings.cpp
        Array/59.SpiralMatrixII.cpp
        Array/605_CanPlaceFlowers.cpp
        Array/628_MaximumProductofThreeNumbers.cpp
        Array/62_UniquePaths.cpp
        Array/643_MaximumAverageSubarrayI.cpp
        Array/64_MinimumPathSum.cpp
        Array/661_ImageSmoother.cpp
        Array/695.MaxAreaofIsland.cpp
        Array/697.DegreeofanArray.cpp
        Array/717_1-bitand2-bitCharacters.cpp
        Array/718_MaximumLengthofRepeatedSubarray.cpp
        Array/724_FindPivotIndex.cpp
        Array/73_SetMatrixZeroes.cpp
        Array/747_LargestNumberAtLeastTwiceofOthers.cpp
        Array/74_Searcha2DMatrix.cpp
        Array/75_SortColors.cpp
        Array/766_ToeplitzMatrix.cpp
        Array/78_Subsets.cpp
        Array/80_RemoveDuplicatesfromSortedArrayII.cpp
        Array/830_PositionsofLargeGroups.cpp
        Array/832_FlippinganImage.cpp
        Array/840.MagicSquaresInGrid.cpp
        Array/849_MaximizeDistancetoClosestPerson.cpp
        Array/870.AdvantageShuffle.cpp
        Array/888.FairCandySwap.cpp
        Array/88_MergeSortedArray.cpp
        Array/896_MonotonicArray.cpp
        Array/8_StringToIntegerAtoi.cpp
        Array/90.SubsetsII.cpp
        Array/905_SortArrayByParity.cpp
        Array/914_XofaKindinaDeckofCards.cpp
        Array/922_SortArrayByParityII.cpp
        Array/941_ValidMountainArray.cpp
        Array/962_MaximumWidthRamp.cpp
        Array/977_SquaresofaSortedArray.cpp
        Backtracking/1219_PathwithMaximumGold.cpp
        Backtracking/37_SudokuSolver.cpp
        Backtracking/46_Permutations.cpp
        Backtracking/47_PermutationsII.cpp
        Backtracking/51_N-Queens.cpp
        Backtracking/52_N-QueensII.cpp
        Backtracking/77_Combinations.cpp
        BFS/1368_MinimumCosttoMakeatLeastOneValidPathinaGrid.cpp
        BinarySearch/1351_CountNegativeNumbersinaSortedMatrix.cpp
        BinarySearch/374_GuessNumberHigherorLower.cpp
        BinarySearch/658_FindKClosestElements.cpp
        BinarySearch/704_BinarySearch.cpp
        BitManuputation/1342_NumberofStepstoReduceaNumbertoZero.cpp
        BitManuputation/136_SingleNumber.cpp
        BitManuputation/191_Numberof1Bits.cpp
        BitManuputation/260_SingleNumberIII.cpp
        BitManuputation/342_PowerofFour.cpp
        Brainteaser/292_NimGame.cpp
        Calendar/1344_AngleBetweenHandsofaClock.cpp
        Calendar/1360_NumberofDaysBetweenTwoDates.cpp
        Design/1352_ProductoftheLastKNumbers.cpp
        Design/1357_ApplyDiscountEverynOrders.cpp
        DFS/1377_FrogPositionAfterTSeconds.cpp
        DFS/5354_TimeNeededtoInformAllEmployees.cpp
        DynamicPrograming/1277_CountSquareSubmatriceswithAllOnes.cpp
        DynamicPrograming/221_MaximalSquare.cpp
        DynamicPrograming/70_ClimbingStairs.cpp
        Graph/1361_ValidateBinaryTreeNodes.cpp
        Greedy/1353_MaximumNumberofEventsThatCanBeAttended.cpp
        Greedy/45_JumpGameII.cpp
        Greedy/5359_MaximumPerformanceofaTeam.cpp
        HashTable/1338_ReduceArraySizetoTheHalf.cpp
        HashTable/1346_CheckIfNandItsDoubleExist.cpp
        HashTable/36_ValidSudoku.cpp
        HashTable/5336_IncreasingDecreasingString.cpp
        Heap/264_UglyNumberII.cpp
        Math/1009_ComplementofBase10Integer.cpp
        Math/1025_DivisorGame.cpp
        Math/1037_ValidBoomerang.cpp
        Math/1103_DistributeCandiestoPeople.cpp
        Math/1217_PlaywithChips.cpp
        Math/1281_SubtracttheProductandSumofDigitsofanInteger.cpp
        Math/1317_ConvertIntegertotheSumofTwoNo-ZeroIntegers.cpp
        Math/1323_Maximum69Number.cpp
        Math/1359_CountAllValidPickupandDeliveryOptions.cpp
        Math/1362_ClosestDivisors.cpp
        Math/1363_LargestMultipleofThree.cpp
        Math/168_ExcelSheetColumnTitle.cpp
        Math/171_ExcelSheetColumnNumber.cpp
        Math/172_FactorialTrailingZeroes.cpp
        Math/202_HappyNumber.cpp
        Math/204_CountPrimes.cpp
        Math/223_RectangleArea.cpp
        Math/231_PowerofTwo.cpp
        Math/258_AddDigits.cpp
        Math/263_UglyNumber.cpp
        Math/326_PowerofThree.cpp
        Math/357_CountNumberswithUniqueDigits.cpp
        Math/367_ValidPerfectSquare.cpp
        Math/413_ArithmeticSlices.cpp
        Math/441_ArrangingCoins.cpp
        Math/453_MinimumMovestoEqualArrayElements.cpp
        Math/507_PerfectNumber.cpp
        "Math/50_Pow(x,n).cpp"
        Math/5353_BulbSwitcherIII.cpp
        Math/598_RangeAdditionII.cpp
        Math/611_ValidTriangleNumber.cpp
        Math/633_SumofSquareNumbers.cpp
        Math/645_SetMismatch.cpp
        "Math/69_Sqrt(x).cpp"
        Math/728_SelfDividingNumbers.cpp
        Math/7_ReverseInteger.cpp
        Math/812_LargestTriangleArea.cpp
        Math/836_RectangleOverlap.cpp
        Math/868_BinaryGap.cpp
        Math/883_ProjectionAreaof3DShapes.cpp
        Math/892_SurfaceAreaof3DShapes.cpp
        Math/908_SmallestRangeI.cpp
        Math/942_DIStringMatch.cpp
        Math/970_PowerfulIntegers.cpp
        Math/976_LargestPerimeterTriangle.cpp
        Math/9_PalindromeNumber.cpp
        SlidingWindow/1343_NumberofSub-arraysofSizeKandAverageGreaterthanorEqualtoThreshold.cpp
        SlidingWindow/1358_NumberofSubstringsContainingAllThreeCharacters.cpp
        Sort/1356_SortIntegersbyTheNumberof1Bits.cpp
        Sort/242_ValidAnagram.cpp
        Sort/5345_RankTeamsbyVotes.cpp
        "String/1003_Check If Word Is Valid After Substitutions.cpp"
        "String/1016_Binary String With Substrings Representing 1 To N.cpp"
        "String/1071_Greatest Common Divisor of Strings.cpp"
        "String/1108_Defanging an IP Address.cpp"
        "String/1138_Alphabet Board Path.cpp"
        "String/1169_Invalid Transactions.cpp"
        "String/1170_Compare Strings by Frequency of the Smallest Character.cpp"
        "String/1189_Maximum Number of Balloons.cpp"
        "String/1221_Split a String in Balanced Strings.cpp"
        "String/125_Valid Palindrome.cpp"
        "String/12_Integer to Roman.cpp"
        "String/1309_Decrypt String from Alphabet to Integer Mapping.cpp"
        String/1371_FindtheLongestSubstringContainingVowelsinEvenCounts.cpp
        "String/13_Roman to Integer.cpp"
        "String/14_Longest Common Prefix.cpp"
        "String/151_Reverse Words in a String.cpp"
        "String/17_Letter Combinations of a Phone Number.cpp"
        "String/227_Basic Calculator II.cpp"
        "String/22_Generate Parentheses.cpp"
        "String/273_Integer to English Words.cpp"
        "String/28_Implement strStr().cpp"
        "String/344_Reverse String.cpp"
        "String/345_Reverse Vowels of a String.cpp"
        "String/383_Ransom Note.cpp"
        "String/387_First Unique Character in a String.cpp"
        "String/415_Add Strings.cpp"
        "String/434_Number of Segments in a String.cpp"
        "String/43_Multiply Strings.cpp"
        "String/443_String Compression.cpp"
        "String/459_Repeated Substring Pattern.cpp"
        "String/49_Group Anagrams.cpp"
        "String/520_Detect Capital.cpp"
        "String/521_Longest Uncommon Subsequence I.cpp"
        "String/522_Longest Uncommon Subsequence II.cpp"
        "String/537_Complex Number Multiplication.cpp"
        "String/539_Minimum Time Difference.cpp"
        "String/541_Reverse String II.cpp"
        "String/553_Optimal Division.cpp"
        "String/556_Next Greater Element III.cpp"
        "String/557_Reverse Words in a String III.cpp"
        "String/58_Length of Last Word.cpp"
        "String/5_Longest Palindromic Substring.cpp"
        "String/647_Palindromic Substrings.cpp"
        "String/657_Robot Return to Origin.cpp"
        "String/674_Longest Continuous Increasing Subsequence.cpp"
        "String/678_Valid Parenthesis String.cpp"
        "String/67_Add Binary.cpp"
        "String/680_Valid Palindrome II.cpp"
        "String/686_Repeated String Match.cpp"
        "String/696_Count Binary Substrings.cpp"
        "String/6_ZigZag Conversion.cpp"
        "String/709_To Lower Case.cpp"
        "String/71_Simplify Path.cpp"
        "String/767_Reorganize String.cpp"
        "String/788_Rotated Digits.cpp"
        "String/791_Custom Sort String.cpp"
        "String/804_Unique Morse Code Words.cpp"
        "String/809_Expressive Words.cpp"
        "String/824_Goat Latin.cpp"
        "String/833_Find And Replace in String.cpp"
        "String/848. Shifting Letters.cpp"
        "String/856_Score of Parentheses.cpp"
        "String/859_Buddy Strings.cpp"
        "String/893_Groups of Special-Equivalent Strings.cpp"
        "String/916_Word Subsets.cpp"
        "String/917_Reverse Only Letters.cpp"
        "String/91_Decode Ways.cpp"
        "String/925_Long Pressed Name.cpp"
        "String/929_Unique Email Addresses.cpp"
        "String/937_Reorder Data in Log Files.cpp"
        "String/93_Restore IP Addresses.cpp"
        Tree/1302_DeepestLeavesSum.cpp
        Tree/1325_DeleteLeavesWithaGivenValue.cpp
        Tree/1339_MaximumProductofSplittedBinaryTree.cpp
        Tree/1379_FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree.cpp
        Tree/199_BinaryTreeRightSideView.cpp
        Tree/5179_BalanceaBinarySearchTree.cpp
        Tree/5338_LongestZigZagPathinaBinaryTree.cpp
        Tree/5339_MaximumSumBSTinBinaryTree.cpp
        Tree/5346_LinkedListinBinaryTree.cpp
        Tree/671_SecondMinimumNodeInaBinaryTree.cpp
        Tree/814_BinaryTreePruning.cpp
        TwoPointers/1347_MinimumNumberofStepstoMakeTwoStringsAnagram.cpp
        TwoPointers/240_Searcha2DMatrixII.cpp
        TwoPointers/977_SquaresofaSortedArray.cpp TwoPointers/524_LongestWordInDictionaryThroughDeleting.cpp BinarySearch/162FindPeakElement.cpp Trie/\$208_ImplementTriePrefixTree.cpp SlidingWindow/2009_MinimumNumberOfOperationsToMakeArrayContinuous.cpp)
