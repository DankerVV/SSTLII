.386
.model flat, stdcall
option casemap:none

include c:\masm32\include\masm32rt.inc

.code

suma proc x:DWORD,y:DWORD
mov eax, x
add eax, y
ret
suma endp

resta proc z:DWORDmov eax, z
sub eax, z
ret
resta endp

main proc
local resul1:DWORD
local resul2:DWORD
mov eax, 10
push eax
mov eax, 5
push eax
call suma
mov resul1, eax
mov eax, resul1
print str$(eax)
mov eax, resul1
push eax
call resta
mov resul2, eax
mov eax, resul2
print str$(eax)
invoke ExitProcess, 0

main endp
end main