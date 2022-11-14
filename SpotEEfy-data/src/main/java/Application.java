import org.json.JSONObject;
import org.json.JSONArray;
import project.spotEEfy.core.service.PlaylistService;
import project.spotEEfy.core.entity.Song;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.net.URL;

public class Application {

    public static void main(String[] args) {
        //Get Playlist's Item
        JSONObject json = new JSONObject("{\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"track\": {\n" +
                "                \"album\": {\n" +
                "                    \"href\": \"https://api.spotify.com/v1/albums/2pANdqPvxInB0YvcDiw4ko\",\n" +
                "                    \"images\": [\n" +
                "                        {\n" +
                "                            \"height\": 640,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d0000b273ce6d0eef0c1ce77e5f95bbbc\",\n" +
                "                            \"width\": 640\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 300,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00001e02ce6d0eef0c1ce77e5f95bbbc\",\n" +
                "                            \"width\": 300\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 64,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00004851ce6d0eef0c1ce77e5f95bbbc\",\n" +
                "                            \"width\": 64\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"Progressive Psy Trance Picks Vol.8\"\n" +
                "                },\n" +
                "                \"artists\": [\n" +
                "                    {\n" +
                "                        \"external_urls\": {\n" +
                "                            \"spotify\": \"https://open.spotify.com/artist/6eSdhw46riw2OUHgMwR8B5\"\n" +
                "                        },\n" +
                "                        \"href\": \"https://api.spotify.com/v1/artists/6eSdhw46riw2OUHgMwR8B5\",\n" +
                "                        \"id\": \"6eSdhw46riw2OUHgMwR8B5\",\n" +
                "                        \"name\": \"Odiseo\",\n" +
                "                        \"type\": \"artist\",\n" +
                "                        \"uri\": \"spotify:artist:6eSdhw46riw2OUHgMwR8B5\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"duration_ms\": 376000,\n" +
                "                \"name\": \"Api\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"track\": {\n" +
                "                \"album\": {\n" +
                "                    \"href\": \"https://api.spotify.com/v1/albums/6nlfkk5GoXRL1nktlATNsy\",\n" +
                "                    \"images\": [\n" +
                "                        {\n" +
                "                            \"height\": 640,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d0000b273aa2ff29970d9a63a49dfaeb2\",\n" +
                "                            \"width\": 640\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 300,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00001e02aa2ff29970d9a63a49dfaeb2\",\n" +
                "                            \"width\": 300\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 64,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00004851aa2ff29970d9a63a49dfaeb2\",\n" +
                "                            \"width\": 64\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"Wellness & Dreaming Source\"\n" +
                "                },\n" +
                "                \"artists\": [\n" +
                "                    {\n" +
                "                        \"external_urls\": {\n" +
                "                            \"spotify\": \"https://open.spotify.com/artist/5VQE4WOzPu9h3HnGLuBoA6\"\n" +
                "                        },\n" +
                "                        \"href\": \"https://api.spotify.com/v1/artists/5VQE4WOzPu9h3HnGLuBoA6\",\n" +
                "                        \"id\": \"5VQE4WOzPu9h3HnGLuBoA6\",\n" +
                "                        \"name\": \"Vlasta Marek\",\n" +
                "                        \"type\": \"artist\",\n" +
                "                        \"uri\": \"spotify:artist:5VQE4WOzPu9h3HnGLuBoA6\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"duration_ms\": 730066,\n" +
                "                \"name\": \"Is\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"track\": {\n" +
                "                \"album\": {\n" +
                "                    \"href\": \"https://api.spotify.com/v1/albums/4hnqM0JK4CM1phwfq1Ldyz\",\n" +
                "                    \"images\": [\n" +
                "                        {\n" +
                "                            \"height\": 640,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d0000b273ee0d0dce888c6c8a70db6e8b\",\n" +
                "                            \"width\": 640\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 300,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00001e02ee0d0dce888c6c8a70db6e8b\",\n" +
                "                            \"width\": 300\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 64,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00004851ee0d0dce888c6c8a70db6e8b\",\n" +
                "                            \"width\": 64\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"This Is Happening\"\n" +
                "                },\n" +
                "                \"artists\": [\n" +
                "                    {\n" +
                "                        \"external_urls\": {\n" +
                "                            \"spotify\": \"https://open.spotify.com/artist/066X20Nz7iquqkkCW6Jxy6\"\n" +
                "                        },\n" +
                "                        \"href\": \"https://api.spotify.com/v1/artists/066X20Nz7iquqkkCW6Jxy6\",\n" +
                "                        \"id\": \"066X20Nz7iquqkkCW6Jxy6\",\n" +
                "                        \"name\": \"LCD Soundsystem\",\n" +
                "                        \"type\": \"artist\",\n" +
                "                        \"uri\": \"spotify:artist:066X20Nz7iquqkkCW6Jxy6\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"duration_ms\": 401440,\n" +
                "                \"name\": \"All I Want\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"track\": {\n" +
                "                \"album\": {\n" +
                "                    \"href\": \"https://api.spotify.com/v1/albums/2usKFntxa98WHMcyW6xJBz\",\n" +
                "                    \"images\": [\n" +
                "                        {\n" +
                "                            \"height\": 640,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d0000b2738b7447ac3daa1da18811cf7b\",\n" +
                "                            \"width\": 640\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 300,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00001e028b7447ac3daa1da18811cf7b\",\n" +
                "                            \"width\": 300\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 64,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d000048518b7447ac3daa1da18811cf7b\",\n" +
                "                            \"width\": 64\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"Glenn Horiuchi Trio / Gelenn Horiuchi Quartet: Mercy / Jump Start / Endpoints / Curl Out / Earthworks / Mind Probe / Null Set / Another Space (A)\"\n" +
                "                },\n" +
                "                \"artists\": [\n" +
                "                    {\n" +
                "                        \"external_urls\": {\n" +
                "                            \"spotify\": \"https://open.spotify.com/artist/272ArH9SUAlslQqsSgPJA2\"\n" +
                "                        },\n" +
                "                        \"href\": \"https://api.spotify.com/v1/artists/272ArH9SUAlslQqsSgPJA2\",\n" +
                "                        \"id\": \"272ArH9SUAlslQqsSgPJA2\",\n" +
                "                        \"name\": \"Glenn Horiuchi Trio\",\n" +
                "                        \"type\": \"artist\",\n" +
                "                        \"uri\": \"spotify:artist:272ArH9SUAlslQqsSgPJA2\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"duration_ms\": 358760,\n" +
                "                \"name\": \"Endpoints\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"track\": {\n" +
                "                \"album\": {\n" +
                "                    \"href\": \"https://api.spotify.com/v1/albums/0ivM6kSawaug0j3tZVusG2\",\n" +
                "                    \"images\": [\n" +
                "                        {\n" +
                "                            \"height\": 640,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d0000b27304e57d181ff062f8339d6c71\",\n" +
                "                            \"width\": 640\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 300,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d00001e0204e57d181ff062f8339d6c71\",\n" +
                "                            \"width\": 300\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"height\": 64,\n" +
                "                            \"url\": \"https://i.scdn.co/image/ab67616d0000485104e57d181ff062f8339d6c71\",\n" +
                "                            \"width\": 64\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"All The Best (Spanish Version)\"\n" +
                "                },\n" +
                "                \"artists\": [\n" +
                "                    {\n" +
                "                        \"external_urls\": {\n" +
                "                            \"spotify\": \"https://open.spotify.com/artist/2KftmGt9sk1yLjsAoloC3M\"\n" +
                "                        },\n" +
                "                        \"href\": \"https://api.spotify.com/v1/artists/2KftmGt9sk1yLjsAoloC3M\",\n" +
                "                        \"id\": \"2KftmGt9sk1yLjsAoloC3M\",\n" +
                "                        \"name\": \"Zucchero\",\n" +
                "                        \"type\": \"artist\",\n" +
                "                        \"uri\": \"spotify:artist:2KftmGt9sk1yLjsAoloC3M\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"duration_ms\": 176093,\n" +
                "                \"name\": \"You Are So Beautiful\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        //DEBUT
        JSONArray array= json.getJSONArray("items");
        String photo= null;
        String album_title= null;
        Map<String, String> artistsByNameAndId = new LinkedHashMap<>();
        JSONArray artists= null;
        String duration= null;
        String name= null;

        List<Song> tracklist = new ArrayList<Song>();
        for (int i = 0; i < array.length(); i++){
            //Get Album Photo & Name
            photo=array.getJSONObject(i).getJSONObject("track").getJSONObject("album").getJSONArray("images").getJSONObject(0).getString("url");
            album_title= array.getJSONObject(i).getJSONObject("track").getJSONObject("album").getString("name");

            //Get artists details (name)
            artists=array.getJSONObject(i).getJSONObject("track").getJSONArray("artists");
            for(int y = 0; y< artists.length(); y++) {
                //id= getJSONObject(y).getString("id")
                //name=getJSONObject(y).getString("name")
                artistsByNameAndId.put( artists.getJSONObject(y).getString("id") , artists.getJSONObject(y).getString("name") );
            }

            //get track duration and name
            duration=array.getJSONObject(i).getJSONObject("track").getString("duration_ms");
            name=array.getJSONObject(i).getJSONObject("track").getString("name");

            Map.Entry<String,String> entry = artistsByNameAndId.entrySet().iterator().next();
            tracklist.add(new Song(entry.getValue(), name, duration, album_title, photo ));
        }
        //FIN
        //OUTPUT : tracklist -> List<Song>
        //UNUSED : artistsByNameAndId -> HashMap < artist_id, artist_name> (for each artist)

    }

    
}
