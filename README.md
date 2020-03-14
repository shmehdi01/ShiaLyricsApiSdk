# ShiaLyricsApiSdk
  1. [Load Artist](#load-artist)
  2. [Load Years](#load-years)
  3. [Load Titles of Lyrics](#load-titles-of-lyrics)
  4. [Load Lyrics](#load-lyrics)
  5. [Search Api](#search-api)
  6. [Get Search Count](#get-search-count)
  
You can get lyrics of many Nauhakhan Artist by using this sdk.

Lyrics Available: Nauha, Manqabat and Marsiya

## Setup

  Step 1. Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }
      
  Step 2. Add the dependency
   
     dependencies {
            implementation 'com.github.shmehdi01:ShiaLyricsApiSdk:v1.0.0'
      }
    
## How To Use 

  ShiaLyricsApi  

      ShiaLyricsApi lyricApi = new LyricsApi.Builder().createApi();
      
   setQuery
   
      NAUHAKHAN //if you want to load Artist
      YEAR //if you want to laod Years
      LIST = //if you want to load Titles of Lyrics
      LYRICS //if you want to laod lyrics
      SEARCH_COUNT //if you want fetch search count
      SEARCH //if you want to create search type api builder 
      
   ApiType

      NAUHA
      MANQABAT
      MARSIYA
      
   E.g
   
      ShiaLyricsApi shiaLyricsApi = new LyricsApi.Builder()
                  .setFormat(ApiFormat.JSON)
                  .setQuery(ApiQuery.NAUHAKHAN) //Set Query e.g ApiQuery.NAUHAKHAN
                  .setType(ApiType.NAUHA) //Set Type e.g ApiType.NAUHA
                  .setLoader(this)
                  .setErrorListener(this)
                  .createApi();

# Examples

## Load Artist

     public void getArtist() {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi.Builder()
                .setFormat(ApiFormat.JSON)
                .setQuery(ApiQuery.NAUHAKHAN)
                .setType(ApiType.NAUHA) //GET Artist For Nauha, Manqabat, Marsiya
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getArtist(new LyricsApi.ApiResponse<List<Artist>>() {
            @Override
            public void onResponse(List<Artist> artists) {
                //Do What You Want
                Log.d(TAG, "RESPONSE_ARTIST: " + artists.size() );

                //getYear(artists.get(9));
            }
        });
    }
    
  ## Load Years 
  
     public void getYear(final Artist artist) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setFormat(ApiFormat.JSON)
                .setType(ApiType.NAUHA) //GET Year For Nauha, Manqabat, Marsiya
                .setQuery(ApiQuery.YEAR)
                .setLoader(this)
                .setErrorListener(this)
                .setId(artist.getId())
                .createApi();

        shiaLyricsApi.getYears(new LyricsApi.ApiResponse<List<Year>>() {
            @Override
            public void onResponse(List<Year> years) {
                //do
                Log.d(TAG, "RESPONSE_YEAR: " + years.size() );

                //getTitle(artist,years.get(0));
            }
        });
    }
    
 ## Load Titles of Lyrics
 
     public void getTitle(Artist artist, Year year) {
            ShiaLyricsApi shiaLyricsApi = new LyricsApi
                    .Builder()
                    .setFormat(ApiFormat.JSON)
                    .setType(ApiType.NAUHA) //GET Title For Nauha, Manqabat, Marsiya
                    .setQuery(ApiQuery.LIST)
                    .setId(artist.getId())
                    .setYear(year.getYear())
                    .setLoader(this)
                    .setErrorListener(this)
                    .createApi();

        shiaLyricsApi.getTitles(new LyricsApi.ApiResponse<List<Title>>() {
            @Override
            public void onResponse(List<Title> titles) {
                //do
                Log.d(TAG, "RESPONSE_TITLES: " + titles.size() );

                //getLyrics(titles.get(0));
            }
        });
    }
    
 ## Load Lyrics
 
      public void getLyrics(Title title) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setType(ApiType.NAUHA) //GET Lyrics For Nauha, Manqabat, Marsiya
                .setQuery(ApiQuery.LYRICS)
                .setId(title.getId())
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getLyrics(new LyricsApi.ApiResponse<Lyrics>() {
            @Override
            public void onResponse(Lyrics lyrics) {
                //do
                Log.d(TAG, "RESPONSE_LYRICS: " + lyrics.getLyrics() );
            }
        });
    }
    
  ## Search Api
  
     public void searchLyrics(String keyword) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setFormat(ApiFormat.JSON)
                .setQuery(ApiQuery.SEARCH)
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getSearch(keyword, new LyricsApi.ApiResponse<List<SearchResult>>() {
            @Override
            public void onResponse(List<SearchResult> searchResults) {
                //do
                Log.d(TAG, "RESPONSE_SEARCH: " + searchResults.size() );
            }
        });
    }

## Get Search Count

    public void searchCount(String keywords) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setQuery(ApiQuery.SEARCH_COUNT)
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getSearchCount(keywords, new LyricsApi.ApiResponse<String>() {
            @Override
            public void onResponse(String count) {
                //do
                Log.d(TAG, "RESPONSE_SEARCH_COUNT: " + count);
            }
        });
    }
