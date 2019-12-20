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
   : (assignstmt | callstmt | beginstmt | ifstmt | whilestmt | dowhilestmt | forstmt | ternarstmt | writestmt | readstmt)?
   ;

assignstmt
   : (ident | ident_arr) (':=' (ident | ident_arr))* ':=' expression
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
    : ident ':=' condition '?' expression ':' expression
    ;

writestmt
    : WRITE '(' string_expression ')'
    ;

readstmt
    : READ '(' ident ')'
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
    : (number_expression | bool_expression | string_expression)
    ;

bool_expression
    : (NEG)? (BOOLEAN | ident) ((AND | OR) (NEG)? (BOOLEAN | ident))*
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
   | ('(' number_expression ')')
   ;

ident_arr
    : ident '[' NUMBER ']'
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

READ
    : 'read'
    ;

WRITE
    : 'write'
    ;

CONST
    : 'const'
    ;

TYPE
    : ('int' | 'bool' | 'string')
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