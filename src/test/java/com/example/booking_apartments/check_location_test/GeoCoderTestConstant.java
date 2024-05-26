package com.example.booking_apartments.check_location_test;

public class GeoCoderTestConstant {

    public final static String GEO_RESPONSE_VALUE= "{\n" +
            "    \"documentation\": \"https://opencagedata.com/api\",\n" +
            "    \"licenses\": [\n" +
            "        {\n" +
            "            \"name\": \"see attribution guide\",\n" +
            "            \"url\": \"https://opencagedata.com/credits\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"rate\": {\n" +
            "        \"limit\": 2500,\n" +
            "        \"remaining\": 2499,\n" +
            "        \"reset\": 1716163200\n" +
            "    },\n" +
            "    \"results\": [\n" +
            "        {\n" +
            "            \"annotations\": {\n" +
            "                \"DMS\": {\n" +
            "                    \"lat\": \"55° 47' 41.45316'' N\",\n" +
            "                    \"lng\": \"37° 47' 1.36644'' E\"\n" +
            "                },\n" +
            "                \"MGRS\": \"37UDB2374383916\",\n" +
            "                \"Maidenhead\": \"KO85vt40bs\",\n" +
            "                \"Mercator\": {\n" +
            "                    \"x\": 4206063.679,\n" +
            "                    \"y\": 7482317.342\n" +
            "                },\n" +
            "                \"OSM\": {\n" +
            "                    \"edit_url\": \"https://www.openstreetmap.org/edit?way=207417720#map=16/55.79485/37.78371\",\n" +
            "                    \"note_url\": \"https://www.openstreetmap.org/note/new#map=16/55.79485/37.78371&layers=N\",\n" +
            "                    \"url\": \"https://www.openstreetmap.org/?mlat=55.79485&mlon=37.78371#map=16/55.79485/37.78371\"\n" +
            "                },\n" +
            "                \"UN_M49\": {\n" +
            "                    \"regions\": {\n" +
            "                        \"EASTERN_EUROPE\": \"151\",\n" +
            "                        \"EUROPE\": \"150\",\n" +
            "                        \"RU\": \"643\",\n" +
            "                        \"WORLD\": \"001\"\n" +
            "                    },\n" +
            "                    \"statistical_groupings\": [\n" +
            "                        \"MEDC\"\n" +
            "                    ]\n" +
            "                },\n" +
            "                \"callingcode\": 7,\n" +
            "                \"currency\": {\n" +
            "                    \"alternate_symbols\": [\n" +
            "                        \"руб.\",\n" +
            "                        \"р.\"\n" +
            "                    ],\n" +
            "                    \"decimal_mark\": \",\",\n" +
            "                    \"format\": \"%n %u\",\n" +
            "                    \"html_entity\": \"&#x20BD;\",\n" +
            "                    \"iso_code\": \"RUB\",\n" +
            "                    \"iso_numeric\": \"643\",\n" +
            "                    \"name\": \"Russian Ruble\",\n" +
            "                    \"smallest_denomination\": 1,\n" +
            "                    \"subunit\": \"Kopeck\",\n" +
            "                    \"subunit_to_unit\": 100,\n" +
            "                    \"symbol\": \"₽\",\n" +
            "                    \"symbol_first\": 0,\n" +
            "                    \"thousands_separator\": \".\"\n" +
            "                },\n" +
            "                \"flag\": \"\uD83C\uDDF7\uD83C\uDDFA\",\n" +
            "                \"geohash\": \"ucfv7v1k83d34t0gm2jg\",\n" +
            "                \"qibla\": 176.63,\n" +
            "                \"roadinfo\": {\n" +
            "                    \"drive_on\": \"right\",\n" +
            "                    \"road\": \"3-я Парковая улица\",\n" +
            "                    \"speed_in\": \"km/h\"\n" +
            "                },\n" +
            "                \"sun\": {\n" +
            "                    \"rise\": {\n" +
            "                        \"apparent\": 1716081060,\n" +
            "                        \"astronomical\": 0,\n" +
            "                        \"civil\": 1716078000,\n" +
            "                        \"nautical\": 1716159480\n" +
            "                    },\n" +
            "                    \"set\": {\n" +
            "                        \"apparent\": 1716140460,\n" +
            "                        \"astronomical\": 0,\n" +
            "                        \"civil\": 1716143520,\n" +
            "                        \"nautical\": 1716148560\n" +
            "                    }\n" +
            "                },\n" +
            "                \"timezone\": {\n" +
            "                    \"name\": \"Europe/Moscow\",\n" +
            "                    \"now_in_dst\": 0,\n" +
            "                    \"offset_sec\": 10800,\n" +
            "                    \"offset_string\": \"+0300\",\n" +
            "                    \"short_name\": \"MSK\"\n" +
            "                },\n" +
            "                \"what3words\": {\n" +
            "                    \"words\": \"tens.renamed.clutter\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"bounds\": {\n" +
            "                \"northeast\": {\n" +
            "                    \"lat\": 55.7952486,\n" +
            "                    \"lng\": 37.7846091\n" +
            "                },\n" +
            "                \"southwest\": {\n" +
            "                    \"lat\": 55.7945812,\n" +
            "                    \"lng\": 37.7828092\n" +
            "                }\n" +
            "            },\n" +
            "            \"components\": {\n" +
            "                \"ISO_3166-1_alpha-2\": \"RU\",\n" +
            "                \"ISO_3166-1_alpha-3\": \"RUS\",\n" +
            "                \"ISO_3166-2\": [\n" +
            "                    \"RU-MOW\"\n" +
            "                ],\n" +
            "                \"_category\": \"commerce\",\n" +
            "                \"_normalized_city\": \"Moscow\",\n" +
            "                \"_type\": \"shop\",\n" +
            "                \"city\": \"Moscow\",\n" +
            "                \"continent\": \"Europe\",\n" +
            "                \"country\": \"Russia\",\n" +
            "                \"country_code\": \"ru\",\n" +
            "                \"house_number\": \"24\",\n" +
            "                \"postcode\": \"105043\",\n" +
            "                \"region\": \"Central Federal District\",\n" +
            "                \"road\": \"3-я Парковая улица\",\n" +
            "                \"shop\": \"Торговый центр \\\"Парагон\\\"\",\n" +
            "                \"state\": \"Moscow\",\n" +
            "                \"suburb\": \"Izmaylovo District\"\n" +
            "            },\n" +
            "            \"confidence\": 9,\n" +
            "            \"distance_from_q\": {\n" +
            "                \"meters\": 75\n" +
            "            },\n" +
            "            \"formatted\": \"Торговый центр \\\"Парагон\\\", 3-я Парковая улица, 24, Izmaylovo District, Moscow, Russia, 105043\",\n" +
            "            \"geometry\": {\n" +
            "                \"lat\": 55.7948481,\n" +
            "                \"lng\": 37.7837129\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": {\n" +
            "        \"code\": 200,\n" +
            "        \"message\": \"OK\"\n" +
            "    },\n" +
            "    \"stay_informed\": {\n" +
            "        \"blog\": \"https://blog.opencagedata.com\",\n" +
            "        \"mastodon\": \"https://en.osm.town/@opencage\"\n" +
            "    },\n" +
            "    \"thanks\": \"For using an OpenCage API\",\n" +
            "    \"timestamp\": {\n" +
            "        \"created_http\": \"Sun, 19 May 2024 10:15:29 GMT\",\n" +
            "        \"created_unix\": 1716113729\n" +
            "    },\n" +
            "    \"total_results\": 1\n" +
            "}";
}
