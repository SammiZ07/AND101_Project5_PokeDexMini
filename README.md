AND101 Project 5 - Choose Your Own API

Submitted by: Carlos Hernandez

Time spent: 12 hours spent in total

Summary

PokéDex Mini is an android app that fetches Pokémon data from the free PokéAPI and displays the sprite image, name, type(s), and size (height & weight). It includes a Random button and a search field to look up by name or numeric ID.

If I had to describe this project in three (3) emojis, they would be: 🔍⚡️📱

Application Features
<!-- (This is a comment) Please be sure to change the [ ] to [x] for any features you completed. If a feature is not checked [x], you might miss the points for that item! -->

The following REQUIRED features are completed:

x Make an API call to an API of your choice using AsyncHTTPClient

x Display at least three (3) pieces of data for each API entry retrieved

x A working Button requests a new API entry and updates the data displayed

The following STRETCH features are implemented:

x Add a query to the API request

The query I added is lookup by Pokémon name (e.g., pikachu) or numeric ID (e.g., 25) via https://pokeapi.co/api/v2/pokemon/{query}

x Build a UI to allow users to add that query

The following EXTRA features are implemented:

x Image loading with Glide

x ViewBinding for safer UI access

x Random button selects valid IDs (1–898)

x Basic error messaging on failed requests

x Adaptive launcher icons

x Android 12+ compliant (android:exported in Manifest)

x Gradle/Java aligned to 17

API Choice

My chosen API for this project is PokéAPI.

Video Demo

Here's a video / GIF that demos all of the app's implemented features:

![Screen Recording 2025-10-03 at 9 24 22 PM](https://github.com/user-attachments/assets/c6091aaa-a282-44bc-bba1-10a80c54bdd1)


GIF created with Kap (macOS)


Notes

Here's a place for any other notes on the app, it's creation process, or what you learned this unit!

Uses CodePath AsyncHTTPClient (com.codepath.libraries:asynchttpclient:2.2.0).

Layout is ConstraintLayout and uses ViewBinding.

Height/weight converted from decimeters/hectograms to meters/kilograms.

Clears the ImageView if a sprite URL is missing to avoid stale images.

License

Copyright 2025 Carlos Hernandez

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0


Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
