grammar Lang;

program
   : block '.'
   ;

block
   : (declaration)* (procedure)* statement
   ;

declaration
    : (consts | constarrays | vars)
    ;

procedure
   : PROCEDURE ident ';' block ';'
   ;

consts
   : CONST TYPE ident ':=' value ';'
   ;

constarrays
    : CONST TYPE ident '[]' ':=' '{' value (',' value)* '}' ';'
    ;

vars
   : VAR TYPE (ident | ident_arr ) ( ',' (ident | ident_arr))* ';'
   ;

statement
   : (assignstmt | parallelstmt | callstmt | beginstmt | ifstmt | whilestmt | dowhilestmt | forstmt | ternarstmt)?
   ;

assignstmt
   : (ident | ident_arr) (':=' (ident | ident_arr))* ':=' expression
   ;

parallelstmt
    : '{' (ident | ident_arr) (',' (ident | ident_arr))* '}' ':=' '{' (expression) (',' (expression))* '}'
    ;

callstmt
   : CALL ident
   ;

beginstmt
   : BEGIN statement (';' statement)* END
   ;

ifstmt
   : IF condition THEN statement (ELSE statement)?
   ;

whilestmt
   : WHILE condition DO statement
   ;

dowhilestmt
    : DO statement WHILE condition
    ;

forstmt
    : FOR ident ':=' number_expression TO number_expression DO statement
    ;

ternarstmt
    : (ident | ident_arr) ':=' condition '?' expression ':' expression
    ;

condition
   : '('
        (
        (number_expression ( LESS | LESS_EQ | GREATER | GREATER_EQ ) number_expression)
        | (expression ( EQ | NOT_EQ ) expression)
        | (bool_expression)
        )
     ')'
   ;

expression
    : (bool_expression | string_expression | number_expression)
    ;

bool_expression
    : (NEG)? (BOOLEAN | (ident | ident_arr)) ((AND | OR) (NEG)? (BOOLEAN | (ident | ident_arr)))*
    ;

string_expression
    : (ident | STRING_VALUE) (PLUS (ident | STRING_VALUE))*
    ;

number_expression
   : (PLUS | MINUS)? term ((PLUS | MINUS) term)*
   ;

term
   : factor ((MUL | DIV) factor)*
   ;

factor
   : NUMBER
   | ident
   | ident_arr
   | ('(' number_expression ')')
   ;

ident_arr
    : ident '[' (NUMBER | ident) ']'
    ;

ident
    : LETTER (LETTER | NUMBER)*
    ;

value
    : (NUMBER | BOOLEAN | STRING_VALUE)
    ;

CALL
    : 'call'
    ;

PROCEDURE
    : 'procedure'
    ;

VAR
    : 'var'
    ;

THEN
    : 'then'
    ;

BEGIN
    : 'begin'
    ;

END
    : 'end'
    ;

ELSE
    : 'else'
    ;

WHILE
    : 'while'
    ;

DO
    : 'do'
    ;

FOR
    : 'for'
    ;

TO
    : 'to'
    ;

IF
    : 'if'
    ;

CONST
    : 'const'
    ;

TYPE
    : ('int' | 'bool' | 'char')
    ;

STRING_VALUE
    : '"' (LETTER | NUMBER)* '"'
    ;

BOOLEAN
    : ('true' | 'false')
    ;

LETTER
    : [a-zA-Z]
    ;

NUMBER
    : [0-9]+
    ;

LESS
    : '<'
    ;

LESS_EQ
    : '<='
    ;

GREATER
    : '>'
    ;

GREATER_EQ
    : '>='
    ;

EQ
    : '='
    ;

NOT_EQ
    : '!='
    ;

NEG
    : '!'
    ;

AND
    : '&&'
    ;

OR
    : '||'
    ;

MUL
    : '*'
    ;

DIV
    : '/'
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

WS
   : [ \t\r\n] -> channel(HIDDEN)
   ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;