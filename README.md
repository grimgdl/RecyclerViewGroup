## Recycler Group

It is a widget that implement a custom recyclerview in group



### How to implement
[![](https://jitpack.io/v/grimarj89/RecyclerViewGroup.svg)](https://jitpack.io/#grimarj89/RecyclerViewGroup)

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy

    allprojects {
		repositories {
			//...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```groovy
    dependencies {
	        implementation 'com.github.grimgdl:RecyclerViewGroup:$version'

	}

```



### How to use



```xml
<com.grimco.recyclergroup.recycler.view.RecyclerGroupGrim
    android:id="@+id/recycler"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:groupTextColor="#126F87"
/>

```
You can change the Group color adding `app:groupTextColor="#000000"` attribute 

Also you can add the `app:filter=true` to activate filter

```kotlin

val recycler = findViewById(R.id.recycler)

//data format is in the next section
val data = "{}"

recycler.loadData(data)


```


Api Consume example

```json

    {
        "data": [{ "brand": "" , "product":[{"id": , "name": "test1", "presentation":"3L", "img":"https://image.com/300.jpg"},...] }, ...]
    }
```



### Preview

<img src="https://user-images.githubusercontent.com/4397770/202604276-8fe85087-f058-4087-b28b-a2eec24fb1ef.gif" width="300" height="auto"/>


