package ee.transliteration.icao;

public class IcaoTransliterationRules {

    private static final String ICAO_MULTINATIONAL_CHARACTER_RULES =
            "\u00C1 > A ; \u00E1 > a; " + // 1. A acute
            "\u00C0 > A; \u00E0 > a; " + // 2. A grave
            "\u00C2 > A; \u00E2 > a; " + // 3. A circumflex
            "\u00C4 > AE; \u00E4 > ae; " + // 4. A diaeresis
            "\u00C3 > A; \u00E3 > a; " + // 5. A tilde
            "\u0102 > A; \u0103 > a; " + // 6. A breve
            "\u00C5 > AA; \u00E5 > aa; " + // 7. A ring
            "\u0100 > A; \u0101 > a; " + // 8. A macron
            "\u0104 > A; \u0105 > a; " + // 9. A ogonek
            "\u0106 > C; \u0107 > c; " + // 10. C acute
            "\u0108 > C; \u0109 > c; " + // 11. C circumflex
            "\u010C > C; \u010D > c; " + // 12. C caron
            "\u010A > C; \u010B > c; " + // 13. C dot accent
            "\u00C7 > C; \u00E7 > c; " + // 14. C cedilla
            "\u00D0 > D; \u00F0 > d; " + // 15. Eth
            "\u0110 > D; \u0111 > d; " + // 16. D with Stroke
            "\u010E > D; \u010F > d; " + // 17. D Caron
            "\u00C9 > E; \u00E9 > e; " + // 18. E acute
            "\u00C8 > E; \u00E8 > e; " + // 19. E grave
            "\u00CA > E; \u00EA > e; " + // 20. E circumflex
            "\u00CB > E; \u00EB > e; " + // 21. E diaeresis
            "\u011A > E; \u011B > e; " + // 22. E caron
            "\u0116 > E; \u0117 > e; " + // 23. E dot accent
            "\u0112 > E; \u0113 > e; " + // 24. E macron
            "\u0118 > E; \u0119 > e; " + // 25. E ogonek
            "\u0114 > E; \u0115 > e; " + // 26. E breve
            "\u011C > G; \u011D > g; " + // 27. G circumflex
            "\u011E > G; \u011F > g; " + // 28. G breve
            "\u0120 > G; \u0121 > g; " + // 29. G dot accent
            "\u0122 > G; \u0123 > g; " + // 30. G cedilla
            "\u0126 > H; \u0127 > h; " + // 31. H bar
            "\u0124 > H; \u0125 > h; " + // 32. H circumflex
            "\u0049 > I; \u0131 > i; " + // 33. I without dot (Turkey)
            "\u00CD > I; \u00ED > i; " + // 34. I acute
            "\u00CC > I; \u00EC > i; " + // 35. I grave
            "\u00CE > I; \u00EE > i; " + // 36. I circumflex
            "\u00CF > I; \u00EF > i; " + // 37. I diaeresis
            "\u0128 > I; \u0129 > i; " + // 38. I tilde
            "\u0130 > I; \u0069 > i; " + // 39. I dot accent
            "\u012A > I; \u012B > i; " + // 40. I macron
            "\u012E > I; \u012F > i; " + // 41. I ogonek
            "\u012C > I; \u012D > i; " + // 42. I breve
            "\u0134 > J; \u0135 > j; " + // 43. J circumflex
            "\u0136 > K; \u0137 > k; " + // 44. K cedilla
            "\u0141 > L; \u0142 > l; " + // 45. L slash
            "\u0139 > L; \u013A > l; " + // 46. L acute
            "\u013D > L; \u013E > l; " + // 47. L caron
            "\u013B > L; \u013C > l; " + // 48. L cedilla
            "\u013F > L; \u0140 > l; " + // 49. L dot
            "\u0143 > N; \u0144 > n; " + // 50. N acute
            "\u00D1 > N; \u00F1 > n; " + // 51. N tilde
            "\u0147 > N; \u0148 > n; " + // 52. N caron
            "\u0145 > N; \u0146 > n; " + // 53. N cedilla
            "\u014A > N; \u014B > n; " + // 54. Eng
            "\u00D8 > OE; \u00F8 > oe; " + // 55. O slash
            "\u00D3 > O; \u00F3 > o; " + // 56. O acute
            "\u00D2 > O; \u00F2 > o; " + // 57. O grave
            "\u00D4 > O; \u00F4 > o; " + // 58. O circumflex
            "\u00D6 > OE; \u00F6 > oe; " + // 59. O diaeresis
            "\u00D5 > O; \u00F5 > o; " + // 60. O tilde
            "\u0150 > O; \u0151 > o; " + // 61. O double acute
            "\u014C > O; \u014D > o; " + // 62. O macron
            "\u014E > O; \u014F > o; " + // 63. O breve
            "\u0154 > R; \u0155 > r; " + // 64. R acute
            "\u0158 > R; \u0159 > r; " + // 65. R caron
            "\u0156 > R; \u0157 > r; " + // 66. R cedilla
            "\u015A > S; \u015B > s; " + // 67. S acute
            "\u015C > S; \u015D > s; " + // 68. S circumflex
            "\u0160 > S; \u0161 > s; " + // 69. S caron
            "\u015E > S; \u015F > s; " + // 70. S cedilla
            "\u0166 > T; \u0167 > t; " + // 71. T bar
            "\u0164 > T; \u0165 > t; " + // 72. T caron
            "\u0162 > T; \u0163 > t; " + // 73. T cedilla
            "\u00DA > U; \u00FA > u; " + // 74. U acute
            "\u00D9 > U; \u00F9 > u; " + // 75. U grave
            "\u00DB > U; \u00FB > u; " + // 76. U circumflex
            "\u00DC > UE; \u00FC > ue; " + // 77. U diaeresis
            "\u0168 > U; \u0169 > u; " + // 78. U tilde
            "\u016C > U; \u016D > u; " + // 79. U breve
            "\u0170 > U; \u0171 > u; " + // 80. U double acute
            "\u016E > U; \u016F > u; " + // 81. U ring
            "\u016A > U; \u016B > u; " + // 82. U macron
            "\u0172 > U; \u0173 > u; " + // 83. U ogonek
            "\u0174 > W; \u0175 > w; " + // 84. W circumflex
            "\u00DD > Y; \u00FD > y; " + // 85. Y acute
            "\u0176 > Y; \u0177 > y; " + // 86. Y circumflex
            "\u0187 > Y; \u00FF > y; " + // 87. Y diaeresis
            "\u0179 > Z; \u017A > z; " + // 88. Z acute
            "\u017D > Z; \u017E > z; " + // 89. Z caron
            "\u017B > Z; \u017C > z; " + // 90. Z dot
            "\u00DE > TH; \u00FE > th; " + // 91. Thorn (Iceland)
            "\u00C6 > AE; \u00E6 > ae; " + // 92. ligature AE
            "\u0132 > IJ; \u0133 > ij; " + // 93. ligature IJ
            "\u0152 > OE; \u0153 > oe; " + // 94. ligature OE
            "\u00DF > SS;"; // 95. double ss (Germany)

    private static final String ICAO_CYRILLIC_CHARACTER_RULES =
            "\u0410 > A; \u0430 > a; " + // 1. A
            "\u0411 > B; \u0431 > b; " + // 2. B
            "\u0412 > V; \u0432 > v; " + // 3. V
            // 4. G
            "\u0414 > D; \u0434 > d; " + // 5. D
            "\u0415 > E; \u0435 > e; " + // 6. E
            // 7. E
            // 8. ZH
            "\u0417 > Z; \u0437 > z; " + // 9. Z
            // 10. I
            "\u0406 > I; \u0456 > i; " + // 11. I
            // 12. I
            "\u041A > K; \u043A > k; " + // 13. K
            "\u041B > L; \u043B > l; " + // 14. L
            "\u041C > M; \u043C > m; " + // 15. M
            "\u041D > N; \u043D > n; " + // 16. N
            "\u041E > O; \u043E > o; " + // 17. O
            "\u041F > P; \u043F > p; " + // 18. P
            "\u0420 > R; \u0440 > r; " + // 19. R
            "\u0421 > S; \u0441 > s; " + // 20. S
            "\u0422 > T; \u0442 > t; " + // 21. T
            "\u0423 > U; \u0443 > u; " + // 22. U
            "\u0424 > F; \u0444 > f; " + // 23. F
            // 24. KH
            // 25. TS
            // 26. CH
            // 27. SH
            // 28. SHCH
            "\u042B > Y; \u044B > y; " + // 29. Y
            // 30. IE
            "\u042C > E; \u044C > e; " + // 31. Y
            "\u042D > E; \u044D > e; " + // 32. E
            // 33. IU
            "\u042F > IA; \u044F > ia; " + // 34. IA
            "\u0474 > Y; \u0475 > y; " + // 35. Y
            "\u0490 > G; \u0491 > g; " + // 36. G
            "\u040E > U; \u045E > u; " + // 37. U
            "\u046A > U; \u046B > u; " + // 38. U
            "\u0403 > G; \u0453 > g; " + // 39. G
            "\u0402 > D; \u0452 > d; " + // 40. D
            "\u0405 > DZ; \u0455 > dz; " + // 41. DZ
            "\u0408 > J; \u0458 > j; " + // 42. J
            "\u040C > K; \u045C > k; " + // 43. K
            "\u0409 > LJ; \u0459 > lj; " + // 44. LJ
            "\u040A > NJ; \u045A > nj; " + // 45. NJ
            "\u040B > C; \u045B > c; " + // 46. C
            "\u040F > DZ; \u045F > dz; " + // 47. DZ
            "\u0404 > IE; \u0454 > ie; " + // 48. IE
            "\u0407 > I; \u0457 > i;" + // 49. I
            "\u0413 > G; \u0433 > g; " + // 4. G (except Belorussian and Former Yugoslav Republic of Macedonia = H)
            "\u0401 > E; \u0451 > e; " + // 7. E (except Belorussian = IO)
            "\u0416 > ZH; \u0436 > zh; " + // 8. ZH (except Former Yugoslav Republic of Macedonia = Z)
            "\u0418 > I; \u0438 > i; " + // 10. I (except Ukrainian = Y)
            "\u0419 > I; \u0439 > i; " + // 12. I (except Bulgarian = Y)
            "\u0425 > KH; \u0445 > kh; " + // 24. KH (except Former Yugoslav Republic of Macedonia and Bulgaria = H)
            "\u0426 > TS; \u0446 > ts; " + // 25. TS (except Former Yugoslav Republic of Macedonia = C)
            "\u0427 > CH; \u0447 > ch; " + // 26. CH (except Former Yugoslav Republic of Macedonia = C)
            "\u0428 > SH; \u0448 > sh; " + // 27. SH (except Former Yugoslav Republic of Macedonia = S)
            "\u0429 > SHCH; \u0449 > shch; " + // 28. SHCH (except Bulgarian = SHT)
            "\u042A > IE; \u044A > ie; " + // 30. IE (Except Bulgarian = A)
            "\u042E > IU; \u044E > iu; "; // 33. IU (except Bulgarian = YU)

    private static String[][] ICAO_PUNCTUATION = {
            {"\u0027", ""},// 1. Apostrophe(')
            {"\u02BC", ""},
            {"\u055A", ""},
            {"\u07F4", ""},
            {"\u07F5", ""},
            {"\u2019", ""},
            {"\uFF07", ""},
            {"\u002D", " "}, // 2. Hyphen(-)
            {"\u058A", " "},
            {"\u2010", " "},
            {"\u2011", " "},
            {"\uFF0D", " "},
            {"\u002C", " "} // 3. Comma(,)
    };

    public static String[] getIcaoMultinationalRules() {
        return new String[] {
                ICAO_MULTINATIONAL_CHARACTER_RULES
        };
    }

    public static String[] getIcaoCyrillicRules() {
        return new String[] {
                ICAO_CYRILLIC_CHARACTER_RULES
        };
    }

    public static String[][] getIcaoPunctuationRules() {
        return ICAO_PUNCTUATION;
    }
}


