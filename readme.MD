# MS-Interview

Design pattern: MVVM 
Dipendency Injection: Dagger Hilt
Language: Kotlin
Jetpack component: ViewModel, Navigation, LiveData, Coroutines

Network: Retrofit 2
Image Viewer: Glide

Task
1. An application with a bottom bar holding three buttons containing three fragments.

- Used Navigation component to achieve

2. Load public repos from the Github API, that need to be paginated(refer to relevant documents on GitHub), show a few details on the list item with the image.
 
 - Used retrofit in proper DI pattern and applied pagination for 100 page each.
 
3. Have a way of enabling users to enter comments for each repos(not a post API, Maintain the data in the memory),  and it needs to be shown on the details page.
on click of an item on the list, invoke a detail fragment showing more details on the clicked Item.

- Achieved using LiveData, navigation and customised navcontroler 

4. From detail fragment, when switched to other tabs on  the bottom bar, on Coming back to the first tab, The details fragment needs to be retained - not using any singleton or shared pref to store state use only fragment API.( Kindly ensure this point to be undertaken keenly)

- Achieved through viewModel and instantstate

5. Vanilla or any design pattern is welcome.

- Used MVVM pattern

6. Image loading - Caching of a bitmap is advisable.

- Used Glide to achieve

7. The usage of Jetpack libraries is appreciated.

- Yes, ViewModel, Navigation, LiveData,

8. Make sure configuration changes are handled.

- ViewModel will handel the config changes



